package service;

import dao.PostingDao;
import dao.PostingDaoImp;
import java.util.List;
import model.Posting;

public class WebLogService {

    private PostingDao postingDao;

    public WebLogService() {
        postingDao = new PostingDaoImp();
    }

    public void addPosting(Posting p) {
        postingDao.create(p);
    }

    public List<Posting> getPostings() {
        return postingDao.findAll();
    }

    public void deletePosting(long id) {
        postingDao.deletePosting(id);
    }

    public Posting find(long id) {
        return postingDao.find(id);
    }

    public void editPosting(long id, String title, String content) {
        Posting p = find(id);
        p.setTitle(title);
        p.setContent(content);
        
    }
;
}
