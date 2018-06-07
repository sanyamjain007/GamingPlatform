/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame.model;

/**
 *
 * @author sajain
 */
public class User {
    private String userId;
    private int experience;
    private float starRating;

    public User(String userId, int experience, float starRating) {
        this.userId = userId;
        this.experience = experience;
        this.starRating = starRating;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userId) {
        this.userId = userId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public float getStarrating() {
        return starRating;
    }

    public void setStarrating(float starRating) {
        this.starRating = starRating;
    }
}
