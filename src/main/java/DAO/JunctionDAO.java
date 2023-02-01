    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Animals;
import pojo.Characteristics;
import pojo.Junction;

/**
 *
 * @author vali
 */
public interface JunctionDAO {
    public void addJunction (Junction junction);
    public List<Junction> returnJunction();
    public void modifyJunction (Integer idjunction, Animals animals, Characteristics characteristics);
    public void deleteJunction (Junction junction);
}

    
