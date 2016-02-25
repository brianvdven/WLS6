/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.dao;

import java.util.List;
import java.model.Posting;

public interface PostingDao {

    void create(Posting p);

    List<Posting> findAll();

    Posting find(Long id);
}
