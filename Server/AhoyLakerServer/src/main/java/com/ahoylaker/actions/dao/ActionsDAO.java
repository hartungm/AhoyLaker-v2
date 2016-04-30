package com.ahoylaker.actions.dao;

import com.ahoylaker.actions.model.Action;
import com.ahoylaker.db.connection.AhoyConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionsDAO {

    private static final String INSERT_ACTION = "INSERT INTO actions(id, name, is_link, url, parent_id) VALUES(?, ?, ?, ?, ?)";
    private static final String FIND_ACTIONS_BY_PARENT = "SELECT id, name, is_link, url, parent_id FROM actions WHERE parent_id = ?";

    private Connection conn;

    public ActionsDAO() {
        try {
            this.conn = AhoyConnections.getConnection();
        }
        catch (SQLException slqe) {
            slqe.printStackTrace();
        }
    }

    public List<Action> getActionsByParent(String parentID) {
        List<Action> actions = new ArrayList<>();

        try {
            PreparedStatement stm = conn.prepareStatement(FIND_ACTIONS_BY_PARENT);
            stm.setNString(1, parentID);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Action action = new Action();
                action.setId(rs.getString("id"));
                action.setLink(rs.getInt("is_link") > 0);
                action.setName(rs.getString("name"));
                action.setUrl(rs.getString("url"));
                action.setParentID(rs.getString("parent_id"));
                actions.add(action);
            }
        }
        catch(SQLException sqle) {
            sqle.printStackTrace();
        }

        return actions;
    }

}
