package model;

public class RecipeComment {
	private int uid;
	private String recipe_table;
	private int recipe_uid;
	private String recipe_id;
	private String recipe_name;
	private String recipe_comment;
	private String recipe_date;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getRecipe_table() {
		return recipe_table;
	}
	public void setRecipe_table(String recipe_table) {
		this.recipe_table = recipe_table;
	}
	public int getRecipe_uid() {
		return recipe_uid;
	}
	public void setRecipe_uid(int recipe_uid) {
		this.recipe_uid = recipe_uid;
	}
	public String getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(String recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getRecipe_comment() {
		return recipe_comment;
	}
	public void setRecipe_comment(String recipe_comment) {
		this.recipe_comment = recipe_comment;
	}
	public String getRecipe_date() {
		return recipe_date;
	}
	public void setRecipe_date(String recipe_date) {
		this.recipe_date = recipe_date;
	}
	
	@Override
	public String toString() {
		return "RecipeComment [uid=" + uid + ", recipe_table=" + recipe_table + ", recipe_uid=" + recipe_uid
				+ ", recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", recipe_comment=" + recipe_comment
				+ ", recipe_date=" + recipe_date + ", getUid()=" + getUid() + ", getRecipe_table()=" + getRecipe_table()
				+ ", getRecipe_uid()=" + getRecipe_uid() + ", getRecipe_id()=" + getRecipe_id() + ", getRecipe_name()="
				+ getRecipe_name() + ", getRecipe_comment()=" + getRecipe_comment() + ", getRecipe_date()="
				+ getRecipe_date() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
