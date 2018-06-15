import React from 'react';
import Comment from './comment';

class Comments extends React.Component {
    	render() {
    		var comments = this.props.allComments.map(comment =>
    			<Comment key={comment._links.self.href} comment={comment}/>
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
