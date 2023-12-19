package com.coindesk.demo.services.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CoinTime {
    public String updated;
    public String updatedISO;
    public String updateduk;

    // Getter and Setter methods

    // public String getUpdated() {
    //     return updated;
    // }

    // public void setUpdated(String updated) {
    //     this.updated = updated;
    // }

    // public String getUpdatedISO() {
    //     return updatedISO;
    // }

    // public void setUpdatedISO(String updatedISO) {
    //     this.updatedISO = updatedISO;
    // }

    // public String getUpdateduk() {
    //     return updateduk;
    // }

    // public void setUpdateduk(String updateduk) {
    //     this.updateduk = updateduk;
    // }
}
