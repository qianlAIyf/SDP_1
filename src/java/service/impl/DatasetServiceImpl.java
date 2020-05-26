package service.impl;

import dao.interf.DatasetDao;
import model.Dataset;
import org.springframework.stereotype.Service;
import service.interf.DatasetService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DatasetServiceImpl implements DatasetService {
    @Resource
    DatasetDao datasetDao;

    @Override
    public List<Dataset> getDatasets(int user_id) {
        return datasetDao.getDatasets(user_id);
    }

    @Override
    public boolean upload(Dataset dataset){
        datasetDao.uploadDataset(dataset);
        return true;
    }

    @Override
    public Dataset getLatestDataset(int user_id) {
        List<Dataset> datasets = datasetDao.getDatasets(user_id);
        return datasets.get(datasets.size()-1);
    }
}
