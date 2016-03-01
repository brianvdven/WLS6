/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Posting;

public interface PostingDao {

    void create(Posting p);

    List<Posting> findAll();

    Posting find(Long id);
    
    void deletePosting(long id);
}
