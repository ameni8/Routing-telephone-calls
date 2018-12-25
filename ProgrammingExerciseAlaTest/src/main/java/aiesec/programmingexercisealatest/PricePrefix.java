/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiesec.programmingexercisealatest;

/**
 *
 * @author ameni
 */
class PricePrefix {

    private String prefix;
    private Double price;

    public PricePrefix(String prefix, Double price) {
        if(prefix == null || price == null) throw new RuntimeException(); 
        this.prefix = prefix;
        this.price = price;
    }

    public String getPrefix() {
        return prefix;
    }

    public Double getPrice() {
        return price;
    }

    public int getPrefixLength() {
        return this.prefix.length();
    }
public boolean prefixBigger(PricePrefix p){
return this.comparing(p)<=0;
}
public int comparing(PricePrefix p){
    
    if(p.prefix.length()>this.prefix.length()){ return 1;}
    else  if(p.prefix.length()==this.prefix.length())return 0;
    else return -1;
//return  Integer.valueOf(p.prefix.length()).compareTo(this.prefix.length());
}
public boolean lessThan(PricePrefix p) {
		return this.getPrice().compareTo( p.getPrice() ) < 0;
	}
    @Override
    public String toString(){
return "prefix: "+prefix+"price: "+price.toString();
}
}
