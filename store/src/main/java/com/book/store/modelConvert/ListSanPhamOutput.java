package com.book.store.modelConvert;

import java.util.List;

public class ListSanPhamOutput {
    private List<SanPhamOutput> sanPhamOutputs;
    private int totalPages;

    public List<SanPhamOutput> getSanPhamOutputs() {
        return sanPhamOutputs;
    }

    public void setSanPhamOutputs(List<SanPhamOutput> sanPhamOutputs) {
        this.sanPhamOutputs = sanPhamOutputs;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
