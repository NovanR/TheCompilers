package controller;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import java.util.List;

import model.Dropbox;
import model.DropboxMapper;


public class DropboxController {
    private SqlSessionFactory sqlSessionFactory;

    public DropboxController() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Dropbox> getAllDropbox() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DropboxMapper mapper = session.getMapper(DropboxMapper.class);
            return mapper.getAllDropbox();
        }
    }

    public Dropbox getDropboxById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DropboxMapper mapper = session.getMapper(DropboxMapper.class);
            return mapper.getDropboxById(id);
        }
    }

     public void addDropbox(Dropbox dropbox) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DropboxMapper mapper = session.getMapper(DropboxMapper.class);
            mapper.insertDropbox(dropbox);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDropbox(Dropbox dropbox) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DropboxMapper mapper = session.getMapper(DropboxMapper.class);
            mapper.updateDropbox(dropbox);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDropbox(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DropboxMapper mapper = session.getMapper(DropboxMapper.class);
            mapper.deleteDropbox(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
