package com.lemonado.smartmeetserver.core.data.models.roles;

import java.time.OffsetDateTime;

public record RoleModel(
        long id,
        String name,
        String description,
        OffsetDateTime createTimestamp,
        OffsetDateTime updateTimestamp) {

    public static final String ADMIN = "Admin";
    public static final String MANAGER = "Manager";


    public static RoleModelBuilder builder() {
        return new RoleModelBuilder();
    }

    public static final class RoleModelBuilder {
        long id;
        String name;
        String description;
        OffsetDateTime createTimestamp;
        OffsetDateTime updateTimestamp;

        private RoleModelBuilder() {
        }


        public RoleModelBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public RoleModelBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RoleModelBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public RoleModelBuilder withCreateTimestamp(OffsetDateTime createTimestamp) {
            this.createTimestamp = createTimestamp;
            return this;
        }

        public RoleModelBuilder withUpdateTimestamp(OffsetDateTime updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
            return this;
        }

        public RoleModel build() {
            return new RoleModel(id, name, description, createTimestamp, updateTimestamp);
        }
    }
}
