package tn.esprit.IRMCJEE.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.IRMCJEE.persistence.Comment;

@Remote
public interface ServiceCommentRemote{

	public void addComment(Comment c);

	public void updateComment(Comment c);

	public void deleteComment(long id);

	public Comment findById(long id);

	public List<Comment> getListCommentByIdPost(long id);

	public List<Comment> getListCommentByIdResearcher(int id);
}
