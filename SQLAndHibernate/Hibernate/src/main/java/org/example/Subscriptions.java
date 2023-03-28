package org.example;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Subscriptions")
public class Subscriptions {
        @EmbeddedId
        private SubscriptionKey id;

        @Column(name = "subscription_date")
        private LocalDateTime subscriptionDate;

        public SubscriptionKey getId() {
            return id;
        }

        public void setId(SubscriptionKey id) {
            this.id = id;
        }

        public LocalDateTime getSubscriptionDate() {
            return subscriptionDate;
        }

        public void setSubscriptionDate(LocalDateTime subscriptionDate) {
            this.subscriptionDate = subscriptionDate;
        }

}
