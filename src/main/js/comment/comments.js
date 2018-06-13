import React from 'react';
import Comment from './comment';

class Comments extends React.Component {
    render() {
        var comments = this.props.comments.map(comment =>
            <Comment comment={comment}/>
        );
        return (
       <article className='comments-main'>
        <div className='comments-items'>
            {comments}
        </div>
       </article>
         )
    }
}

export default Comments;
