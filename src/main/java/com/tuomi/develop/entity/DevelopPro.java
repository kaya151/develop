package com.tuomi.develop.entity;

import java.io.Serializable;
import java.util.List;

public class DevelopPro implements Serializable {
    private Integer id;

    private String category;

    private String averagePrice;

    private Float ratio;

    private Integer developmentTime;

    private Integer fatherId;

    private Integer twoId;

    private String img;

    private String priceDescription;

    private String competingProducts;
    private List<CoPro>  competingProductsId;
    
    

	public List<CoPro> getCompetingProductsId() {
		return competingProductsId;
	}

	public void setCompetingProductsId(List<CoPro> competingProductsId) {
		this.competingProductsId = competingProductsId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    public Integer getDevelopmentTime() {
        return developmentTime;
    }

    public void setDevelopmentTime(Integer developmentTime) {
        this.developmentTime = developmentTime;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public Integer getTwoId() {
        return twoId;
    }

    public void setTwoId(Integer twoId) {
        this.twoId = twoId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getPriceDescription() {
        return priceDescription;
    }

    public void setPriceDescription(String priceDescription) {
        this.priceDescription = priceDescription == null ? null : priceDescription.trim();
    }
    
	public String getCompetingProducts() {
		return competingProducts;
	}

	public void setCompetingProducts(String competingProducts) {
		this.competingProducts = competingProducts;
	}

	@Override
	public String toString() {
		return "DevelopPro [id=" + id + ", category=" + category + ", averagePrice=" + averagePrice + ", ratio=" + ratio
				+ ", developmentTime=" + developmentTime + ", fatherId=" + fatherId + ", twoId=" + twoId + ", img="
				+ img + ", priceDescription=" + priceDescription + ", competingProducts=" + competingProducts
				+ ", competingProductsId=" + competingProductsId + "]";
	}

	

    
	

	
    
}