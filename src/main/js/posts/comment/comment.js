import React from 'react';

class Comment extends React.Component{
    render() {
        return (
            <div>{this.props.comment}</div>
        )
    }
}

export default Comment;