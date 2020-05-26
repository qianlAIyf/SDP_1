package dao.interf;

import model.Model;

import java.util.List;

public interface ModelDao {
    boolean renameModel(Model model);//重命名模型
    boolean deleteModel(Model model);//删除模型
    List<Model> getModels(int user_id);//获取用户所有的模型
    Model getModel(int id);//根据模型id查看相应的模型
    boolean saveModel(Model model);//保存模型
}
