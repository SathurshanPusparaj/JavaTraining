package com.generics.practicetwo;

public class MultiGenericParam<T,S> {//multi parameter Generics
    private T firstParam;
    private S secondParam;

    public MultiGenericParam(T firstParam,S secondParam){
        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }

    public T getFirstParam(){
        return firstParam;
    }

    public void setFirstParam(T firstParam){
        this.firstParam = firstParam;
    }

    public S getSecondParam(){
        return secondParam;
    }

    public void setSecondParam(S secondParam){
        this.secondParam = secondParam;
    }

    public static void main(String[] args) {
        MultiGenericParam<String,String> aParam = new MultiGenericParam<>("value1","value2");
        System.out.println(aParam.getFirstParam());
        System.out.println(aParam.getSecondParam());
    }
}
