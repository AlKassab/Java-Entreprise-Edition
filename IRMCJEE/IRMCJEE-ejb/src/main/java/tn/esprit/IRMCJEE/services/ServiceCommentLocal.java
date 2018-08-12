package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.IRMCJEE.persistence.Comment;

@Local
public interface ServiceCommentLocal{

	public void addComment(Comment c);

	public void updateComment(Comment c);

	public void deleteComment(long id);

	public Comment findById(long id);

	public List<Comment> getListCommentByIdPost(long id);

	public List<Comment> getListCommentByIdResearcher(int id);
}
