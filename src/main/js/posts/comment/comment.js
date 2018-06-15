import React from 'react';

class Comment extends React.Component{
    render() {
        return [
            <div>{this.props.comment.content}</div>
        ]
    }
}

export default Comment;