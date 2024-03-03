/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class ContentHome {
    private int id;
    private String buttonText;
    private String introduce;
    private String descriptionIntro;
    private String image;

    public ContentHome() {
    }

    public ContentHome(int id, String buttonText, String introduce, String descriptionIntro, String image) {
        this.id = id;
        this.buttonText = buttonText;
        this.introduce = introduce;
        this.descriptionIntro = descriptionIntro;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getDescriptionIntro() {
        return descriptionIntro;
    }

    public void setDescriptionIntro(String descriptionIntro) {
        this.descriptionIntro = descriptionIntro;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
