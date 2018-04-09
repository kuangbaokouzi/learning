package com.laowuandhisfriends.di;

import java.util.*;

public class OneManBand implements Performer {
    public OneManBand() {

    }

    @Override
    public void perform() throws PerformanceException {
        instrumentCollection.forEach(Instrument::play);
    }

    private Collection<Instrument> instrumentCollection;
    private List<Instrument> instrumentList;
    private Instrument[] instruments;
    private Set<Instrument> instrumentSet;
    private Map<String, Instrument> instrumentMap;
    private Properties instrumentProperties;

    public Collection<Instrument> getInstrumentCollection() {
        return instrumentCollection;
    }

    public void setInstrumentCollection(Collection<Instrument> instrumentCollection) {
        this.instrumentCollection = instrumentCollection;
    }

    public List<Instrument> getInstrumentList() {
        return instrumentList;
    }

    public void setInstrumentList(List<Instrument> instrumentList) {
        this.instrumentList = instrumentList;
    }

    public Instrument[] getInstruments() {
        return instruments;
    }

    public void setInstruments(Instrument[] instruments) {
        this.instruments = instruments;
    }

    public Set<Instrument> getInstrumentSet() {
        return instrumentSet;
    }

    public void setInstrumentSet(Set<Instrument> instrumentSet) {
        this.instrumentSet = instrumentSet;
    }

    public Map<String, Instrument> getInstrumentMap() {
        return instrumentMap;
    }

    public void setInstrumentMap(Map<String, Instrument> instrumentMap) {
        this.instrumentMap = instrumentMap;
    }

    public Properties getInstrumentProperties() {
        return instrumentProperties;
    }

    public void setInstrumentProperties(Properties instrumentProperties) {
        this.instrumentProperties = instrumentProperties;
    }
}
