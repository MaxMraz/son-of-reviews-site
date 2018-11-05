package org.wecancodeit.sonofreviewssite.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.sonofreviewssite.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
