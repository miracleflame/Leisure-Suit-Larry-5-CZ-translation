;;; Sierra Script 1.0 - (do not remove this comment)
(script# 450)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm450 0
)

(local
	local0
)
(instance rm450 of LLRoom
	(properties
		picture 450
		west 445
	)
	
	(method (init)
		(proc0_13 445)
		(proc0_2)
		(super init:)
		(self setScript: sRoom)
		(doc init:)
		(sheet init: hide:)
		(patti init: stopUpd:)
		(Load rsSOUND 455 752 753)
	)
)

(instance sRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry edgeHit: 4)
				(doc stopUpd:)
				(= seconds 2)
			)
			(1
				(proc0_18 Dr__Phil_Hopian 450 0 108 139 self)
			)
			(2
				(proc0_18 Dr__Phil_Hopian 450 1 108 139 self)
			)
			(3 (doc setCycle: CT 2 1 self))
			(4
				(sheet show:)
				(doc setCycle: End self)
			)
			(5
				(doc hide:)
				(gLongSong number: 450 setLoop: 1 flags: 1 play: self)
			)
			(6
				(doc show: setCycle: CT 2 -1 self)
			)
			(7
				(sheet hide:)
				(doc setCycle: Beg self)
			)
			(8 (= ticks 60))
			(9
				(doc setLoop: 2 stopUpd:)
				(= ticks 60)
			)
			(10
				(proc0_18 Dr__Phil_Hopian 450 2 108 139 self)
			)
			(11 (= seconds 3))
			(12
				(doc setLoop: 0 stopUpd:)
				(= cycles 3)
			)
			(13
				(proc0_18 Dr__Phil_Hopian 450 3 108 139 self)
			)
			(14
				(proc0_18 gLarry 450 4 67 -1 185)
				(= cycles 1)
			)
			(15
				(proc0_18 Dr__Phil_Hopian 450 5 108 139 self)
			)
			(16
				(proc0_18 gLarry 450 6 67 -1 185)
				(= ticks 60)
			)
			(17
				(proc0_18 Dr__Phil_Hopian 450 7 108 139 self)
			)
			(18
				(proc0_14 450 8 67 -1 185)
				(= cycles 10)
			)
			(19
				(doc setLoop: 3 setCel: 0)
				(= seconds 3)
			)
			(20
				(proc0_18 Dr__Phil_Hopian 450 9 108 139 self)
			)
			(21 (= seconds 2))
			(22
				(proc0_14 450 10 67 -1 185)
				(= seconds 2)
			)
			(23
				(doc setCycle: End self)
				(sheet view: 452 show:)
			)
			(24
				(gLongSong number: 451 setLoop: 1 flags: 1 play: self)
			)
			(25
				(ShakeScreen 6 1)
				(if (DoSound sndSET_SOUND) (soundFX number: 752 play:))
				(= seconds 2)
			)
			(26 (doc setCycle: Beg self))
			(27
				(doc stopUpd:)
				(sheet stopUpd:)
				(= cycles 3)
			)
			(28
				(proc0_18 Dr__Phil_Hopian 450 11 108 139 self)
			)
			(29 (= seconds 3))
			(30
				(sheet startUpd:)
				(doc setCycle: End self)
			)
			(31
				(gLongSong number: 452 setLoop: 1 flags: 1 play: self)
			)
			(32
				(if (DoSound sndSET_SOUND) (soundFX number: 753 play:))
				(ShakeScreen 6 3)
				(= seconds 2)
			)
			(33 (doc setCycle: Beg self))
			(34
				(doc stopUpd:)
				(sheet stopUpd:)
				(= seconds 2)
			)
			(35
				(proc0_18 Dr__Phil_Hopian 450 12 108 139 self)
			)
			(36 (= seconds 2))
			(37
				(sheet startUpd:)
				(doc setCycle: End self)
			)
			(38
				(gLongSong number: 453 setLoop: 1 flags: 1 play: self)
			)
			(39
				(sheet view: 450 show:)
				(doc setLoop: 0 setCel: 255 setCycle: CT 2 -1 self)
			)
			(40
				(sheet hide:)
				(doc setCycle: Beg self)
			)
			(41
				(doc stopUpd:)
				(= cycles 3)
			)
			(42
				(doc
					view: 452
					setLoop: 0
					setCel: 0
					y: (+ (doc y?) 2)
					setCycle: CT 8 1 self
				)
			)
			(43 (= seconds 2))
			(44
				(doc x: 166 y: 126 setCycle: End self)
			)
			(45
				(sheet view: 452 show:)
				(= ticks 67)
			)
			(46
				(soundFX number: 455 play:)
				(= ticks 350)
			)
			(47
				(doc y: (- (doc y?) 2) setLoop: 2 setCel: 0)
				(= seconds 2)
			)
			(48
				(sheet hide:)
				(doc setCel: 1)
				(= seconds 3)
			)
			(49
				(doc setCel: 0)
				(sheet show:)
				(= cycles 10)
			)
			(50 (doc hide:) (= cycles 10))
			(51
				(gLongSong number: 454 setLoop: 1 flags: 1 play: self)
				(sheet dispose:)
				(patti dispose:)
				(global2 style: 6 drawPic: 1)
				(= seconds 3)
			)
			(52
				(proc0_25 2 global128 450 13)
				(= seconds 3)
			)
			(53
				(proc0_2)
				(global2 newRoom: (global2 west?))
			)
		)
	)
)

(instance doc of Prop
	(properties
		x 167
		y 98
		view 450
		cycleSpeed 30
	)
)

(instance sheet of View
	(properties
		x 166
		y 98
		view 450
		loop 1
		priority 12
		signal $4010
	)
)

(instance patti of View
	(properties
		x 162
		y 149
		view 451
	)
)

(instance Dr__Phil_Hopian of Talker
	(properties
		x 30
		y 5
		nsTop 54
		nsLeft 145
		view 1450
		loop 1
		talkWidth 258
		name "Dr. Phil Hopian"
	)
	
	(method (init)
		(= eyes docEyes)
		(= mouth docMouth)
		(super init: &rest)
	)
)

(instance docEyes of Prop
	(properties
		nsTop 18
		nsLeft 13
		view 1450
		loop 2
		cycleSpeed 30
	)
)

(instance docMouth of Prop
	(properties
		nsTop 21
		nsLeft 14
		view 1450
		cycleSpeed 8
	)
)

(instance soundFX of Sound
	(properties
		flags $0001
	)
)
