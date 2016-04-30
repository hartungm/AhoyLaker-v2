package com.ahoylaker.actions.rest;

import com.ahoylaker.actions.dao.ActionsDAO;
import com.ahoylaker.actions.model.Action;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ActionsRESTController {

    @RequestMapping(value = "/actions/{parent_id}")
    public List<Action> getActionsByParent(@PathVariable("parent_id") String parentID) {
        ActionsDAO dao = new ActionsDAO();
        return dao.getActionsByParent(parentID);
    }
}
