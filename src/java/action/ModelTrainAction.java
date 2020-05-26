package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.Dataset;
import model.Model;
import model.User;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.HttpParameters;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.interf.DatasetService;
import service.interf.ModelService;

import javax.annotation.Resource;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

@Controller("modelTrainAction")
@Scope("prototype")
public class ModelTrainAction extends ActionSupport {
    private File dataset;
    private String datasetContentType;
    private String datasetFileName;
    private String destPath;
    private String destPath1;

    @Resource
    Model model;
    @Resource
    User user;
    @Resource
    Dataset dataset1;
    @Resource
    DatasetService datasetService;
    @Resource
    ModelService modelService;

    public String execute() throws IOException, InterruptedException {
        String method;

        ActionContext context = ActionContext.getContext();
        HttpParameters map = context.getParameters();
        method = map.get("method").getValue();

        String exe = "python3";
        String command;

        if(method.equals("LLE-SVM")){
            command = "D:\\SDP\\code\\train_PCA_DT.py";
        }else if(method.equals("IGA-SVM")){
            command = "D:\\SDP\\code\\train_PCA_SVM.py";
        }else {
            command = "D:\\SDP\\code\\train_NMF_DT.py";
        }

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

        String[] cmdArr = new String[] {exe, command, destPath + datasetFileName, datasetFileName, method};

        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        model.setAccuracy(Double.parseDouble(dis.readLine()));     //准确率
        model.setPrecisiona(Double.parseDouble(dis.readLine()));                     //精确率
        model.setRecall(Double.parseDouble(dis.readLine()));                        //召回率
        model.setF1Score(Double.parseDouble(dis.readLine()));                     //f1_score
        model.setName(dis.readLine());       //训练数据集对应的模型名称
        model.setPath(dis.readLine());      //模型的保存路径
        model.setMadeTime(new Timestamp(System.currentTimeMillis()));
        model.setMethod(method);
        model.setUserId(user.getId());
        model.setDatasetId(datasetService.getLatestDataset(user.getId()).getId());
        modelService.saveModel(model);
        return SUCCESS;
    }

    public void setDatasetContentType(String datasetContentType) {
        this.datasetContentType = datasetContentType;
    }

    public void setDatasetFileName(String datasetFileName) {
        this.datasetFileName = datasetFileName;
    }

    public void setDataset(File dataset) {
        this.dataset = dataset;
    }
}
