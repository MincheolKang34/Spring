package kr.co.ch06.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser7 is a Querydsl query type for User7
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser7 extends EntityPathBase<User7> {

    private static final long serialVersionUID = 1506575593L;

    public static final QUser7 user7 = new QUser7("user7");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QUser7(String variable) {
        super(User7.class, forVariable(variable));
    }

    public QUser7(Path<? extends User7> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser7(PathMetadata metadata) {
        super(User7.class, metadata);
    }

}

