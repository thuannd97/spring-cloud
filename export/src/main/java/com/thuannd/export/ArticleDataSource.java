package com.thuannd.export;

import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class ArticleDataSource implements  JRDataSource{

    private List<Article> list;
    private int index = -1;

    public ArticleDataSource(List<Article> list){
        this.list = list;
    }

	@Override
	public boolean next() throws JRException {
		index ++;
		return (index < list.size());
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
        Object obj = null;
        String value = jrField.getName();
        switch (value) {
			case "ID":
				obj = list.get(index).getArticleId();
				break;
            case "title":
                obj = list.get(index).getTitle();
				break;
			case "content":
                obj = list.get(index).getContent();
            	break;
            default:
                break;
        }
        return obj;
	}

	public List<Article> getList() {
		return list;
	}

	public void setList(List<Article> list) {
		this.list = list;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

    

}