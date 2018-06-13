import React from 'react';

class Comment extends React.Component{
    render() {
        return [
            <div key="c1" className='comment-content'>{this.props.post.createdAt.split('T')[0]}</div>,
            <div key="c2">{this.props.comment.content}</div>,
            <hr key="c3" />,
        ]
    }
}

expoert default Comment;