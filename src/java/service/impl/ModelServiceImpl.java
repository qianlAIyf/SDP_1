package service.impl;

import dao.interf.ModelDao;
import model.Model;
import org.springframework.stereotype.Service;
import service.interf.ModelService;

import javax.annotation.Resource;

@Service
public class ModelServiceImpl implements ModelService {
    @Resource
    ModelDao modelDao;

    @Override
    public boolean renameModel(Model model) {
        return false;
    }

    @Override
    public boolean deleteModel(Model model) {
        return false;
    }

    @Override
    public Model checkModel(int id) {
        return modelDao.getModel(id);
    }

    @Override
    public boolean saveModel(Model model) {
        modelDao.saveModel(model);
        return true;
    }
}
