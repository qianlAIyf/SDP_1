package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Dataset;
import model.Model;
import model.Report;
import model.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.HttpParameters;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.interf.DatasetService;
import service.interf.ModelService;
import service.interf.ReportService;

import javax.annotation.Resource;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

@Controller("predictAction")
@Scope("prototype")
public class PredictAction extends ActionSupport {
    private File dataset;
    private String datasetContentType;
    private String datasetFileName;
    private String destPath;
    private String destPath1;

    @Resource
    ReportService reportService;
    @Resource
    Report report;
    @Resource
    ModelService modelService;
    @Resource
    User user;
    @Resource
    Model model;
    @Resource
    Dataset dataset1;
    @Resource
    DatasetService datasetService;

    public String execute() throws IOException, InterruptedException {
        String method;
        int model_id;
        String model_path;

        ActionContext context = ActionContext.getContext();
        HttpParameters map = context.getParameters();
//        model_id = Integer.parseInt(map.get("model_id").getValue());
        model_id = 1;

        model = modelService.checkModel(model_id);
        method = model.getMethod();
        model_path = model.getPath();

        String exe = "python3";
        String command;
//        if(method.equals("LLE-SVM") ){
            command = "D:\\SDP\\code\\predict_PCA_DT.py";
//        }else if(method.equals("IGA-SVM")){
//            command = "D:\\SDP\\code\\predict_PCA_SVM.py";
//        }else {
//            command = "D:\\SDP\\code\\predict_NMF_DT.py";
//        }
        destPath = "D:\\codesoftwares\\InterlliJ_IDEA\\project\\SDP_1\\src\\main\\webapp\\dataset\\";
        destPath1 = "D:/codesoftwares/InterlliJ_IDEA/project/SDP_1/src/main/webapp/dataset";

        try{
            File destFile  = new File(destPath, datasetFileName);
            FileUtils.copyFile(dataset, destFile);
        }catch(IOException e){
            e.printStackTrace();
            return ERROR;
        }

        dataset1.setDataType((byte) 1);
        dataset1.setPath(destPath1);
        dataset1.setName(datasetFileName);
        dataset1.setUserId(user.getId());
        dataset1.setLoadTime(new Timestamp(System.currentTimeMillis()));
        datasetService.upload(dataset1);

        String[] cmdArr = new String[] {exe, command, destPath + datasetFileName, datasetFileName, model_path, "LLE"};

        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        report.setPath(dis.readLine());//报告的保存路径
        report.setNumberTrue(Integer.parseInt(dis.readLine())); //预测模块为Y为数目
        report.setNumberFalse(Integer.parseInt(dis.readLine()));//预测模块为N为数目
        process.waitFor();
        report.setDatasetId(datasetService.getLatestDataset(user.getId()).getId());
        report.setMadeTime(new Timestamp(System.currentTimeMillis()));
        report.setModelId(model_id);
        report.setUserId(user.getId());
        report.setName("report_" + datasetFileName + method);
        reportService.saveReport(report);
        return SUCCESS;
    }

    public void setDataset(File dataset) {
        this.dataset = dataset;
    }

    public void setDatasetContentType(String datasetContentType) {
        this.datasetContentType = datasetContentType;
    }

    public void setDatasetFileName(String datasetFileName) {
        this.datasetFileName = datasetFileName;
    }
}
