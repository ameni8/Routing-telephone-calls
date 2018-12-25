/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiesec.programmingexercisealatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ameni
 */
public class Router {

    private List<Operator> operators = new ArrayList<Operator>();

    public static Router router(Operator... operators) {
        return new Router(operators);
    }

    private Router(Operator... operators) {
        Arrays.asList(operators).forEach(this.operators::add);
    }

    public class Process {

        private String operatorName;
        private PricePrefix cheapest;

        public Process(String operatorName, PricePrefix cheapest) {
            this.operatorName = operatorName;
            this.cheapest = cheapest;
        }

        public String getOperatorName() {
            return operatorName;
        }

        public Double getCheapestPrice() {
            return cheapest.getPrice();
        }

        public String getCheapestPrefix() {
            return this.cheapest.getPrefix();
        }
    }

    public Process dial(String phoneNumber) {
        PricePrefix pricePrefix = this.operators.get(0).getCheapestPrice(phoneNumber);
        String operatorName = this.operators.get(0).getName();
        PricePrefix element=null;
        for (int i = 1; i < this.operators.size(); i++) {
            element = this.operators.get(i).getCheapestPrice(phoneNumber);
            
            if (element != null && element.prefixBigger(pricePrefix) && element.lessThan(pricePrefix)) {
                pricePrefix = element;
                operatorName = this.operators.get(i).getName();
            }
            if (pricePrefix != null) {
                return new Process(operatorName, pricePrefix);
            }
        }
        return null;
    }

}
