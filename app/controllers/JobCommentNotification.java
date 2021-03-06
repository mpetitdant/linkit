package controllers;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import models.Comment;
import models.Member;
import models.Setting;
import models.Staff;
import models.activity.CommentActivity;
import play.Logger;
import play.jobs.Every;
import play.jobs.Job;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

// FIXME Restore notification after site migrated out of CloudBees
// @Every("1min")
public class JobCommentNotification extends BaseSinceLastTimeJob {

    public JobCommentNotification() {
        super("CommentNotification");
    }

    @Override
    protected void doJobBetween(Date start, Date end) {

        // Avoid fetching comments since start of the universe.
        // We only want new comments starting now.
        Date realStart = (start == null) ? new Date() : start;

        Logger.debug("Fetching CommentActivity from %s to %s", start, end);

        List<Comment> comments = Comment.between(realStart, end);
        Logger.debug("Found %d comments", comments.size());

        if (!comments.isEmpty()) {
            // Staff people always get notified
            Set<Staff> staff = Sets.newHashSet(Staff.<Staff>findAll());

            for (Comment comment : comments) {

                Logger.debug("Notifying comment %s", comment);

                Set<Member> notifiableMembers = comment.getNotifiableMembers();
                Set<Member> allNotifiablePeople = Sets.union(staff, notifiableMembers);
                for (Member member : allNotifiablePeople) {
                    Mails.commentNotification(member, comment);
                }
            }
        }
    }
}
