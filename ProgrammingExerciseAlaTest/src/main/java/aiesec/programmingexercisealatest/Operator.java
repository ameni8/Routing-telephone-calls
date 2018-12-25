/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiesec.programmingexercisealatest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ameni
 */
public class Operator {

    private String name;
    private List<PricePrefix> pricePrefixList = new ArrayList<PricePrefix>();

    private Operator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<PricePrefix> getPricePrefixList() {
        return pricePrefixList;
    }

    public PricePrefix getCheapestPrice(String phoneNumber) {
        Optional<PricePrefix> o = pricePrefixList.stream().filter(pricePrefix -> Pattern.compile("^" + pricePrefix.getPrefix()).matcher(phoneNumber).find()).findFirst();

        return o.orElse(null);
    }

    public PricePrefix getElement(int i) {
        return this.pricePrefixList.get(i);
    }

    public static class OperatorBuilder {

        private Operator operator;

        private OperatorBuilder(String name) {
            this.operator = new Operator(name);
        }

        public static OperatorBuilder operator(String name) {
            return new OperatorBuilder(name);
        }

        public OperatorBuilder add(PricePrefix pricePrefix) {
            this.operator.getPricePrefixList().add(pricePrefix);
            return this;
        }

        public Operator build() {
            if (this.operator.getPricePrefixList().isEmpty()) {
                throw new RuntimeException();
            }
            this.operator.getPricePrefixList().sort(Comparator.comparingInt(PricePrefix::getPrefixLength).reversed());
            return this.operator;
        }

    }
}
