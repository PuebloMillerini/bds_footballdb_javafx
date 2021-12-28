package org.but.feec.footballdb.data;

import org.but.feec.footballdb.api.*;
import org.but.feec.footballdb.config.DataSourceConfig;
import org.but.feec.footballdb.exceptions.DataAccessException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    public PersonAuthView findPersonByEmail(String email) {

        try (Connection connection = DataSourceConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT email, password" +
                             " FROM public.user u" +
                             " WHERE u.email = ?;")
        ) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapToUserAuth(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException("Find person by ID with addresses failed.", e);
        }
        return null;
    }

//    public UserDetailView findPersonDetailedView(Long user_id) {
//        try (Connection connection = DataSourceConfig.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "SELECT u.user_id, email, firstname, surname, username, city, house_number, street" +
//                             "FROM public.user u" +
//                             "LEFT JOIN public.user_has_address h ON u.user_id = h.user_id" +
//                             "LEFT JOIN public.address a ON h.address_id = a.address_id" +
//                             "WHERE u.user_id = ?;")
//        ) {
//            preparedStatement.setLong(1, user_id);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    return mapToUserDetailView(resultSet);
//                }
//            }
//        } catch (SQLException e) {
//            throw new DataAccessException("Find person by ID with addresses failed.", e);
//        }
//        return null;
//    }
//
//    public List<UserBasicView> getPersonsBasicView() {
//        try (Connection connection = DataSourceConfig.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "SELECT u.user_id, email, firstname, surname, username, city" +
//                             " FROM public.user u" +
//                             " LEFT JOIN user_has_address h on u.user_id = h.user_id" +
//                             " LEFT JOIN public.address a ON h.address_id = a.address_id;");
//             ResultSet resultSet = preparedStatement.executeQuery();) {
//            List<UserBasicView> userBasicViews = new ArrayList<>();
//            while (resultSet.next()) {
//                userBasicViews.add(mapToUserBasicView(resultSet));
//            }
//            return userBasicViews;
//        } catch (SQLException e) {
//            throw new DataAccessException("Persons basic view could not be loaded.", e);
//        }
//    }

    private PersonAuthView mapToUserAuth(ResultSet rs) throws SQLException {
        PersonAuthView person = new PersonAuthView();
        person.setEmail(rs.getString("email"));
        person.setPassword(rs.getString("password"));
        return person;
    }
}