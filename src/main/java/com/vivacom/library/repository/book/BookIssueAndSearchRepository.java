package com.vivacom.library.repository.book;

import com.vivacom.library.enumeratin.IssueStatus;
import com.vivacom.library.enumeratin.SearchingCriteria;
import com.vivacom.library.model.dto.BookDetailsDTO;
import com.vivacom.library.model.dto.BookIssueDTO;
import com.vivacom.library.model.entity.BookIssue;
import com.vivacom.library.repository.common.BaseRepository;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookIssueAndSearchRepository extends BaseRepository implements IBookIssueAndSearchRepository {


    @Override
    public void saveBookIssued(BookIssue bookIssue) {
        em.persist(bookIssue);
    }

    @Override
    public BookIssue getIssuedBookById(Integer issueId){
       return em.find(BookIssue.class,issueId);
    }

    @Override
    public BookIssue updateIssuedBook(BookIssue bookIssue){
        return em.merge(bookIssue);
    }

    @Override
    public BookIssueDTO getIssuedBookListByBookId(int bookId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT A.id AS issueId,A.user_id AS userId,C.id AS bookId,C.book_name AS bookName,");
        query.append(" D.author_id AS authorId,D.author_name AS authorName, E.category_id AS categoryId,");
        query.append(" E.category_name AS categoryName,A.issue_date AS issueDate,A.due_date AS dueDate,");
        query.append(" A.return_date AS returnDate,A.issue_status AS issueStatus");
        query.append(" FROM library.book_issue A");
        query.append(" INNER JOIN library.user B ON A.user_id = B.id ");
        query.append(" INNER JOIN library.book_details C ON A.book_id = C.id ");
        query.append(" INNER JOIN library.author D ON C.author_id = D.author_id ");
        query.append(" INNER JOIN library.book_category E ON C.category_id = E.category_id ");
        query.append(" WHERE C.id = :bookId AND A.issue_status = :issueStatus");

        Query hQuery = hibernateQuery(query.toString(), BookIssueDTO.class);
        hQuery.setParameter("bookId", bookId);
        hQuery.setParameter("issueStatus", IssueStatus.BORROWED.getValue());
        List<BookIssueDTO> bookIssueDTOList =  hQuery.list();
        return (bookIssueDTOList == null || bookIssueDTOList.isEmpty())?null:bookIssueDTOList.get(0);
    }

    @Override
    public List<BookIssueDTO> getIssuedBookListByUserId(int id) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT A.id AS issueId,A.user_id AS userId,C.id AS bookId,C.book_name AS bookName,");
        query.append(" D.author_id AS authorId,D.author_name AS authorName, E.category_id AS categoryId,");
        query.append(" E.category_name AS categoryName,A.issue_date AS issueDate,A.due_date AS dueDate,");
        query.append(" A.return_date AS returnDate,A.issue_status AS issueStatus");
        query.append(" FROM library.book_issue A" );
        query.append(" INNER JOIN library.user B ON A.user_id = B.id " );
        query.append(" INNER JOIN library.book_details C ON A.book_id = C.id " );
        query.append(" INNER JOIN library.author D ON C.author_id = D.author_id " );
        query.append(" INNER JOIN library.book_category E ON C.category_id = E.category_id " );
        query.append(" WHERE A.user_id = :userId AND A.issue_status <> :issueStatus");


        Query hQuery = hibernateQuery(query.toString(), BookIssueDTO.class);
        hQuery.setParameter("userId", id);
        hQuery.setParameter("issueStatus",IssueStatus.RETURNED.getValue());
        return hQuery.list();
    }


    @Override
    public List<BookDetailsDTO> getBookDeatilsBySearch(String keyWord, Integer searchBy) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT  A.id bookId,A.book_name bookName,B.author_name authorName,C.category_name categoryName,");
        builder.append("case when ifnull(D.issue_status,'') = '' OR D.issue_status = :issueReturned THEN '' ELSE D.issue_status END issueStatus ");
        builder.append("FROM library.book_details A ");
        builder.append("INNER JOIN library.author B ON A.author_id = B.author_id ");
        builder.append("INNER JOIN library.book_category C ON A.category_id = C.category_id ");
        builder.append("LEFT JOIN library.book_issue D ON A.id = D.book_id ");


        if (searchBy == SearchingCriteria.NAME.getValue()) {
            builder.append("WHERE A.book_name LIKE :keyWord ");
        } else if (searchBy == SearchingCriteria.AUTHOR.getValue()) {
            builder.append("WHERE B.author_name LIKE :keyWord ");
        } else if (searchBy == SearchingCriteria.BOOK_CATEGORY.getValue()) {
            builder.append("WHERE C.category_name LIKE :keyWord ");
        }


        Query hQuery = hibernateQuery(builder.toString(), BookDetailsDTO.class);
        hQuery.setParameter("issueReturned", IssueStatus.RETURNED.getValue());
        if (searchBy == SearchingCriteria.NAME.getValue() || searchBy == SearchingCriteria.AUTHOR.getValue()
                || searchBy == SearchingCriteria.BOOK_CATEGORY.getValue()) {
            hQuery.setParameter("keyWord", "%"+keyWord+"%");
        }

        return hQuery.list();
    }


}
