package com.vivacom.library.repository.book;

import com.vivacom.library.model.dto.BookCategoryDTO;
import com.vivacom.library.model.dto.BookDetailsDTO;
import com.vivacom.library.model.entity.BookCategory;
import com.vivacom.library.model.entity.BookDetails;
import com.vivacom.library.repository.common.BaseRepository;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ankon on 10/19/2017.
 */
@Repository
public class BooksAndCatgegoryRepository extends BaseRepository implements IBooksAndCategoryRepository {


    @Override
    public void saveBookDetails(BookDetails bookDetails) {
        em.persist(bookDetails);
    }

    @Override
    public BookDetailsDTO getBookDetails(Integer bookId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT A.id AS bookId,A.book_name AS bookName,B.category_id AS categoryId, ");
        query.append("B.category_name AS categoryName,C.author_id AS authorId,C.author_name AS authorName ");
        query.append("FROM library.book_details A ");
        query.append("INNER JOIN book_category B ON A.category_id = B.category_id ");
        query.append("INNER JOIN author C ON A.author_id = C.author_id WHERE A.id = :bookId");
        Query hQuery = hibernateQuery(query.toString(), BookDetailsDTO.class);
        hQuery.setParameter("bookId", bookId);

        List<BookDetailsDTO> bookDetailsDTOList = hQuery.list();
        return (bookDetailsDTOList == null || bookDetailsDTOList.isEmpty()) ? null : bookDetailsDTOList.get(0);
    }


    @Override
    public List<BookDetailsDTO> getBookDetailsList() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT A.id AS bookId,A.book_name AS bookName,B.category_id AS categoryId, ");
        query.append("B.category_name AS categoryName,C.author_id AS authorId,C.author_name AS authorName ");
        query.append("FROM library.book_details A ");
        query.append("INNER JOIN book_category B ON A.category_id = B.category_id ");
        query.append("INNER JOIN author C ON A.author_id = C.author_id");
        Query hQuery = hibernateQuery(query.toString(), BookDetailsDTO.class);
        //hQuery.setParameter("categoryId", categoryId);

        List<BookDetailsDTO> bookDetailsDTOList = hQuery.list();
        return (bookDetailsDTOList == null || bookDetailsDTOList.isEmpty()) ? null : bookDetailsDTOList;
    }

    @Override
    public void saveBookCategory(BookCategory bookCategory) {
        em.persist(bookCategory);
    }

    @Override
    public BookCategoryDTO getBookCategory(int categoryId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT A.category_id categoryId,A.category_name categoryName FROM book_category A WHERE A.category_id = :categoryId");
        Query hQuery = hibernateQuery(query.toString(), BookCategoryDTO.class);
        hQuery.setParameter("categoryId", categoryId);

        List<BookCategoryDTO> bookCategoryDTOList = hQuery.list();
        return (bookCategoryDTOList == null || bookCategoryDTOList.isEmpty()) ? null : bookCategoryDTOList.get(0);
    }

    @Override
    public List<BookCategoryDTO> getBookCategoryList() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT A.category_id categoryId,A.category_name categoryName FROM book_category A");
        Query hQuery = hibernateQuery(query.toString(), BookCategoryDTO.class);

        List<BookCategoryDTO> bookCategoryDTOList = hQuery.list();
        return (bookCategoryDTOList == null || bookCategoryDTOList.isEmpty()) ? null : bookCategoryDTOList;
    }
}
