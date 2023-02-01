    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Characteristics;

/**
 *
 * @author vali
 */
public interface CharacteristicsDAO {
    public void addCharacteristics (Characteristics characteristics);
    public List<Characteristics> returnCharacteristics();
    public void modifyCharacteristics (int idcharacteristics, String Class, String Order, String Species, String Kingdom);
    public void deleteCharacteristics (Characteristics characteristics);
}

    
