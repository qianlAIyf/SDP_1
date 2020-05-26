package service.interf;

import model.Dataset;
import model.Report;

import java.util.List;

public interface ReportService {
    Dataset chooseDataset(int id);//根据数据集id，选择用于预测的历史数据集
    Dataset uploadDataset();//上传用于预测的数据集
    void chooseModel();//选择用于预测的模型
    List<Report> getReports();//获取用户的所有模型
    boolean saveReport(Report report);//保存报告
}
