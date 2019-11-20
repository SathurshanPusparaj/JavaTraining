package com.generics.practicetwo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

interface DataSeries<T,DS extends DataSeries<T,DS>>{
    DS add(DS values);
    List<T> data();
}

interface DoubleSeries extends DataSeries<Double,DoubleSeries>{
    static DoubleSeries instance(Collection<Double> data){
        return new DoubleSeriesImpl(data);
    }
}

public class DoubleSeriesImpl implements DoubleSeries{
    private final List<Double> data;

    DoubleSeriesImpl(Collection<Double> data){
        this.data = new ArrayList<>(data);
    }
    public DoubleSeries add(DoubleSeries values){
        List<Double> incoming = values != null ? values.data() : null;

        if(incoming == null || incoming.size() != data.size()){
            throw new IllegalArgumentException("bad series");
        }
        List<Double> newdata = new ArrayList<>(data.size());
        for (int i=0;i<data.size();i++){
            newdata.add(this.data.get(i));
        }
        return DoubleSeries.instance(newdata);
    }

    @Override
    public List<Double> data() {
        return Collections.unmodifiableList(data);
    }

}
