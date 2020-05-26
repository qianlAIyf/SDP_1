package dao.interf;

import model.Dataset;

import java.util.List;

public interface DatasetDao {
    boolean uploadDataset(Dataset dataset);//上传数据集
    boolean renameDateset(Dataset dataset);//重命名数据集
    boolean deleteDateset(Dataset dataset);//删除数据集
    Dataset downloadDataset(int id);//下载数据集
    List<Dataset> getDatasets(int user_id);//获取所有的数据集
}
