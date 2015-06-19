package controllers;

import models.SaveTextPayload;
import models.ShouldShowNotification;
import models.WordCountModel;
import models.WordCountPayload;
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
        if (payload.userId == null) {
            return badRequest("Expected a fucking user id");
        }
        return ok(payload.userId);
    }


    public Result shouldShowNotification() {
        ShouldShowNotification not = new ShouldShowNotification();
        not.shouldShow = 0;
        return  ok(Json.toJson(not));
    }

    public Result changeNotification() {
        return ok();
    }

    public Result getWordCounts() {
        WordCountPayload payload = new WordCountPayload();
        int[] temp = {12,3,15,17,18,22,7};
        payload.setTotalWordCount(temp);
        WordCountModel models[] = {
                new WordCountModel("Hello", 5),
                new WordCountModel("Contradiction", 15),
                new WordCountModel("Coffee", 16),
                new WordCountModel("Help", 4)

        };
        payload.setTopWords(models);
        return ok(Json.toJson(payload));
    }
}
