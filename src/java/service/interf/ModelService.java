package service.interf;

import model.Model;

public interface ModelService {
    boolean renameModel(Model model);//重命名模型
    boolean deleteModel(Model model);//删除模型
    Model checkModel(int id);//根据模型id查看相应的模型
    boolean saveModel(Model model);//保存模型
}
