package ua.andry.githubrepos.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReposList {

    @SerializedName("total_count")
    @Expose
    private int totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ReposList() {
    }

    /**
     *
     * @param items
     * @param totalCount
     * @param incompleteResults
     */
    public ReposList(int totalCount, boolean incompleteResults, List<Item> items) {
        super();
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public ReposList withTotalCount(int totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public ReposList withIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public ReposList withItems(List<Item> items) {
        this.items = items;
        return this;
    }

}