package controllers;

import models.*;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }




    @BodyParser.Of(BodyParser.Json.class)
    public Result saveWords() {
        SaveTextPayload payload = Json.fromJson(request().body().asJson(), SaveTextPayload.class);
        if (payload.terms == null) {
            return badRequest("Expected a fucking user id");
        }
        for(String word: payload.terms) {
            InMemoryDatabase.getInstance().putWord(word);
        }
        return ok();
    }


    public Result shouldShowNotification() {
        return  ok(Json.toJson(InMemoryDatabase.getInstance().getNotification()));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result changeNotification() {
        ShouldShowNotification not = Json.fromJson(request().body().asJson(), ShouldShowNotification.class);
        InMemoryDatabase.getInstance().setShouldShowNotification(not);
        return ok();
    }

    public Result getWordCounts() {

        return ok(Json.toJson(InMemoryDatabase.getInstance().getWordCountPayload()));
    }
}
