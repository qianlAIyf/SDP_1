package service.interf;

import model.Dataset;

import java.util.List;

public interface DatasetService {
    List<Dataset> getDatasets(int user_id);//获取所有的数据集
    boolean upload(Dataset dataset);//上传数据集
    Dataset getLatestDataset(int user_id);//获取最近插入的数据集
}
