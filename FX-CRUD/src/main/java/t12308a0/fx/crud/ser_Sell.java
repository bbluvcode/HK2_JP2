/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t12308a0.fx.crud;

import javafx.scene.image.ImageView;

/**
 *
 * @author Adminz
 */
public class ser_Sell {

    int idss;
    int idc;
    String name;
    int price;
    int qoh;
    private ImageView img;

    public ser_Sell() {
    }

    public ser_Sell(int idss, int idc, String name, int price, ImageView img, int qoh) {
        this.idss = idss;
        this.idc = idc;
        this.name = name;
        this.price = price;
        this.img = img;
        this.qoh = qoh;
    }

    public int getIdss() {
        return idss;
    }

    public void setIdss(int idss) {
        this.idss = idss;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public int getQoh() {
        return qoh;
    }

    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    @Override
    public String toString() {
        return "ser_rent{" + "idss=" + idss + ", idc=" + idc + ", name=" + name + ", price=" + price + ", img=" + img + ", qoh=" + qoh + '}';
    }

}
