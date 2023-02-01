    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.Animals;

/**
 *
 * @author vali
 */
public interface AnimalsDAO {
    public void addAnimals (Animals animals);
    public List<Animals> returnAnimals();
    public void modifyAnimals (int idanimals, String name, String region);
    public void deleteAnimals (Animals animals);
}

    
