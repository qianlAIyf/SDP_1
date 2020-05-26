package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Dataset;
import model.User;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.interf.DatasetService;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

@Controller("DatasetUpload")
@Scope("prototype")
public class DatasetUploadAction extends ActionSupport {
    private File file;
    private String fileContentType;
    private String fileFileName;
    private String destPath;

    @Resource
    Dataset dataset;
    @Resource
    DatasetService datasetService;
    @Resource
    User user;

    public String execute()
    {
        /* Copy file to a safe location */
        destPath = "D:/codesoftwares/InterlliJ_IDEA/project/SDP_1/src/main/webapp/dataset";

        try{
            File destFile  = new File(destPath, fileFileName);
            FileUtils.copyFile(file, destFile);
        }catch(IOException e){
            e.printStackTrace();
            return ERROR;
        }

        dataset.setDataType((byte) 3);
        dataset.setPath(destPath);
        dataset.setName(fileFileName);
        dataset.setUserId(user.getId());
        dataset.setLoadTime(new Timestamp(System.currentTimeMillis()));
        datasetService.upload(dataset);
        return SUCCESS;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
}
