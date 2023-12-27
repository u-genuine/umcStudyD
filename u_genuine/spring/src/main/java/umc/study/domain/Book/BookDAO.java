package umc.study.domain.Book;

import lombok.Cleanup;
import umc.study.domain.Book.entity.Book;
import umc.study.global.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void insert(Book book) throws Exception{
        String sql = "insert into book (title, author, description, stock) values (?, ?, ?, ?)";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getDescription());
        ps.setInt(4, book.getStock());

        ps.executeUpdate();
    }

    public List<Book> selectAll() throws Exception{

        String sql = "select * from book";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        @Cleanup ResultSet resultSet = ps.executeQuery();

        List<Book> list = new ArrayList<>();

        // ResultSet으로 각 행을 이동하면서 각 행의 데이터를 Book객체로 변환
        while(resultSet.next()){
            Book book = Book.builder()
                    .title(resultSet.getString("title"))
                    .author(resultSet.getString("author"))
                    .description(resultSet.getString("description"))
                    .stock(resultSet.getInt("stock"))
                    .build();

            list.add(book);
        }
        return list;

    }

    public Book selectOne(Long book_id) throws Exception{

        String sql = "select * from book where book_id = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setLong(1, book_id);

        @Cleanup ResultSet resultSet = ps.executeQuery();

        resultSet.next();
        Book book = Book.builder()
                .title(resultSet.getString("title"))
                .author(resultSet.getString("author"))
                .description(resultSet.getString("description"))
                .stock(resultSet.getInt("stock"))
                .build();

        return book;
    }

    public void deleteOne(Long book_id) throws  Exception{
        String sql = "delete from book where book_id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setLong(1, book_id);

        ps.executeUpdate();

    }

    public void updateOne(Book book) throws Exception{
        String sql = "update book set title = ?, author = ?, description = ?, stock = ? where book_id = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getDescription());
        ps.setInt(4, book.getStock());
        ps.setLong(5, book.getId());

        ps.executeUpdate();

    }
}
