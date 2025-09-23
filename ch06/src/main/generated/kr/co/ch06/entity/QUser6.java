package kr.co.ch06.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser6 is a Querydsl query type for User6
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser6 extends EntityPathBase<User6> {

    private static final long serialVersionUID = 1506575592L;

    public static final QUser6 user6 = new QUser6("user6");

    public final StringPath addr = createString("addr");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath gender = createString("gender");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public QUser6(String variable) {
        super(User6.class, forVariable(variable));
    }

    public QUser6(Path<? extends User6> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser6(PathMetadata metadata) {
        super(User6.class, metadata);
    }

}

